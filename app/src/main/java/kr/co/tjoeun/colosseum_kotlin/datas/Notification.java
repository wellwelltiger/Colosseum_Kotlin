package kr.co.tjoeun.colosseum_kotlin.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Notification {

    private int id;
    private int receiverUserId;
    private int actUserId;
    private String  title;
    private String type;
    private String message;
    private String referenceUI;
    private int focusObjectId;
    private Calendar createdAt = Calendar.getInstance();

    public static Notification getNotiFromJson(JSONObject json){
        Notification noti = new Notification();

        try {
            noti.id = json.getInt("id");
            noti.receiverUserId = json.getInt("receive_user_id");
            noti.actUserId = json.getInt("act_user_id");
            noti.title = json.getString("title");
            noti.type = json.getString("type");
            noti.message = json.getString("message");
            noti.referenceUI = json.getString("reference_ui");
            noti.focusObjectId = json.getInt("focus_object_id");

            //작성 일시 string으로 따서 calendar 세팅


            String createdAtStr = json.getString("created_at");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            noti.createdAt.setTime(sdf.parse(createdAtStr));
            TimeZone myPhoneTimeZone = noti.createdAt.getTimeZone();
            int gmtOffset = myPhoneTimeZone.getRawOffset() / 60 / 60 / 1000;
            noti.createdAt.add(Calendar.HOUR_OF_DAY, gmtOffset);


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return noti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(int receiverUserId) {
        this.receiverUserId = receiverUserId;
    }

    public int getActUserId() {
        return actUserId;
    }

    public void setActUserId(int actUserId) {
        this.actUserId = actUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReferenceUI() {
        return referenceUI;
    }

    public void setReferenceUI(String referenceUI) {
        this.referenceUI = referenceUI;
    }

    public int getFocusObjectId() {
        return focusObjectId;
    }

    public void setFocusObjectId(int focusObjectId) {
        this.focusObjectId = focusObjectId;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }
}
