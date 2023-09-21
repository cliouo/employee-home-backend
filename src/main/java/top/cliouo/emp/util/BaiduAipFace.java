package top.cliouo.emp.util;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.cliouo.emp.exception.ServiceException;
import top.cliouo.emp.exception.enums.ServiceExceptionCode;

import java.util.HashMap;
import java.util.List;


@Component
public class BaiduAipFace{

    @Autowired
    private AipFace client;

    /**
     * 人脸检测
     */
    public Boolean faceDetection(String image, String imageType) {
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<>();
        options.put("face_field", "quality,beauty");
        options.put("face_type", "LIVE");
        options.put("liveness_control", "LOW");

        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);

        return checkQuality(res);
    }

    /**
     * 人脸注册
     */
    public String faceRegister(String image, String imageType, String userId) {

        if (!faceDetection(image, imageType)) {
            return null;
        }

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("action_type", "REPLACE");

        String groupId = "emp";

        // 人脸注册
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);
        HashMap<String, Object> hashMap = (HashMap)res.toMap();
        Integer errorCode = (Integer)findValueByKey(hashMap, "error_code");
        if(errorCode != 0){
            throw new ServiceException(ServiceExceptionCode.FACE_REGISTER_ERROR);
        }
        return (String)findValueByKey(hashMap, "face_token");
    }

    /**
     * 人脸搜索
     */
    public String faceSearch(String image, String imageType) {
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("match_threshold", "70");
        String groupIdList = "emp";

        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        HashMap<String, Object> hashMap = (HashMap)res.toMap();

        Integer errorCode = (Integer)findValueByKey(hashMap, "error_code");
        if(errorCode != 0){
            throw new ServiceException(ServiceExceptionCode.FACE_LOGIN_ERROR);
        }
        System.out.println(res.toString(2));
        List userList = (List)findValueByKey(hashMap, "user_list");
        HashMap o = (HashMap)userList.get(0);
        Double score = convertToDouble(findValueByKey(o, "score"));
        String userId = (String)findValueByKey(o, "user_id");
        if(score < 70) {
            return null;
        }
        return userId;
    }

    public Object findValueByKey(HashMap obj, String key) {
        // 先判断当前JSONObject是否包含指定的key
        if (obj.get(key) != null) {
            return obj.get(key);
        }

        // 如果当前JSONObject不包含指定的key，则递归查找子JSONObject
        for (Object k : obj.keySet()) {
            Object value = obj.get(k);
            if (value instanceof HashMap) {
                Object result = findValueByKey((HashMap) value, key);
                if (result != null) {
                    return result;
                }
            }
        }
        // 如果所有子JSONObject中都没有找到指定的key，则返回null
        return null;
    }

    /**
     * 人脸质量检测
     */
    public Boolean checkQuality(JSONObject obj){
        HashMap<String, Object> hashMap = (HashMap)obj.toMap();
        Integer errorCode = (Integer)findValueByKey(hashMap, "error_code");
        if(errorCode != 0){
            throw new ServiceException(ServiceExceptionCode.FACE_REGISTER_ERROR);
        }
        List faceList = (List)findValueByKey(hashMap, "face_list");
        HashMap o = (HashMap)faceList.get(0);

        String faceToken = (String)findValueByKey(o, "face_token");

        HashMap occlusion = (HashMap)findValueByKey(o, "occlusion");
        Double leftEye = convertToDouble(findValueByKey(occlusion, "left_eye"));
        Double rightEye = convertToDouble(findValueByKey(occlusion, "right_eye"));
        Double nose = convertToDouble(findValueByKey(occlusion, "nose"));
        Double mouth = convertToDouble(findValueByKey(occlusion, "mouth"));
        Double left_cheek = convertToDouble(findValueByKey(occlusion, "left_cheek"));
        Double right_cheek = convertToDouble(findValueByKey(occlusion, "right_cheek"));
        Double chin_contour = convertToDouble(findValueByKey(occlusion, "chin_contour"));

        Double blur = convertToDouble(findValueByKey(o, "blur"));
        Integer completeness = (Integer) findValueByKey(o, "completeness");

        Double illumination = convertToDouble(findValueByKey(o, "illumination"));

        Double roll = convertToDouble(findValueByKey(o, "roll"));
        Double yaw = convertToDouble(findValueByKey(o, "yaw"));
        Double pitch = convertToDouble(findValueByKey(o, "pitch"));

        boolean flag = true;

        if(leftEye > 0.6 || rightEye > 0.6 || nose > 0.7 || mouth > 0.7 || left_cheek > 0.8 || right_cheek > 0.8 || chin_contour > 0.6){
            flag = false;
        }

        if(blur > 0.7){
            flag = false;
        }

        if(completeness < 1){
            flag = false;
        }

        if(illumination < 40){
            flag = false;
        }

        if(roll > 20 || yaw > 20 || pitch > 20){
            flag = false;
        }

        return flag;
    }
    public static Double convertToDouble(Object value) {
        Number value1 = (Number) value;
        return value1.doubleValue();
    }
}
