package top.cliouo.emp.util;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return (String)findValueByKey(hashMap, "face_token");
    }

    /**
     * 人脸搜索
     */
    public void faceSearch() {
        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("match_threshold", "70");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("user_id", "233451");
        options.put("max_user_num", "3");

        String image = "取决于image_type参数，传入BASE64字符串或URL字符串或FACE_TOKEN字符串";
        String imageType = "BASE64";
        String groupIdList = "3,2";

        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        System.out.println(res.toString(2));

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
        List faceList = (List)findValueByKey(hashMap, "face_list");
        HashMap o = (HashMap)faceList.get(0);

        String faceToken = (String)findValueByKey(o, "face_token");

        HashMap occlusion = (HashMap)findValueByKey(o, "occlusion");
        Double leftEye = (Double) convertToNumber(findValueByKey(occlusion, "left_eye"));
        Double rightEye = (Double) convertToNumber(findValueByKey(occlusion, "right_eye"));
        Double nose = (Double) convertToNumber(findValueByKey(occlusion, "nose"));
        Double mouth = (Double) convertToNumber(findValueByKey(occlusion, "mouth"));
        Double left_cheek = (Double) convertToNumber(findValueByKey(occlusion, "left_cheek"));
        Double right_cheek = (Double) convertToNumber(findValueByKey(occlusion, "right_cheek"));
        Double chin_contour = (Double) convertToNumber(findValueByKey(occlusion, "chin_contour"));

        Double blur = (Double) convertToNumber(findValueByKey(o, "blur"));
        Integer completeness = (Integer) findValueByKey(o, "completeness");

        Double illumination = (Double) convertToNumber(findValueByKey(o, "illumination"));

        Double roll = (Double) convertToNumber(findValueByKey(o, "roll"));
        Double yaw = (Double) convertToNumber(findValueByKey(o, "yaw"));
        Double pitch = (Double) convertToNumber(findValueByKey(o, "pitch"));

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
    public static Number convertToNumber(Object value) {
        Number value1 = (Number) value;
        if (value instanceof Integer) {
            return value1.doubleValue();
        } else {
            return value1;
        }
    }
}
