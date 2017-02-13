package com.ht.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ���ڶ�ʱ����в����Ĺ�����
 * @author Administrator
 *
 */
public class DateUtil {

	/**
	 * ��ȡ����ǰʱ��
	 * @return
	 */
	public static Date getDate() {
		return Calendar.getInstance().getTime();
	}
	
	/**
	 * ��ȡ��ǰʱ������Ӧ���ַ���
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(date);
	}
	
	/** 
     * ��ʱ���ַ���ת��ΪDate���� 
     * @param dateStr 
     * @return Date 
     */  
    public static Date toDate(String dateStr) {  
        Date date = null;  
        SimpleDateFormat formater = new SimpleDateFormat();  
        formater.applyPattern("yyyy-MM-dd");  
        try {  
            date = formater.parse(dateStr);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return date;  
    } 
	
	/**
	 * �Զ����������ķ���
	 * @param early
	 * @param late
	 * @return
	 */
	public static int countDay(Date startDay, Date endDay) { 
        java.util.Calendar calst = java.util.Calendar.getInstance();   
        java.util.Calendar caled = java.util.Calendar.getInstance();   
        calst.setTime(startDay);   
         caled.setTime(endDay);   
         //����ʱ��Ϊ0ʱ   
         calst.set(java.util.Calendar.HOUR_OF_DAY, 0);   
         calst.set(java.util.Calendar.MINUTE, 0);   
         calst.set(java.util.Calendar.SECOND, 0);   
         caled.set(java.util.Calendar.HOUR_OF_DAY, 0);   
         caled.set(java.util.Calendar.MINUTE, 0);   
         caled.set(java.util.Calendar.SECOND, 0);   
        //�õ�����������������   
         int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst   
                .getTime().getTime() / 1000)) / 3600 / 24;   
         
        return days;   
	}   
	
	/**
     * ���ݴ��ݽ�����ʱ�䣬�Զ���������
     * 
     * @param dt ���ݽ�����ʱ��
     * @return ��ǰ���������ڼ�
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
    
    /**
     * ��������ķ���
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                "����ʱ����ڵ�ǰʱ��!");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;//ע��˴����������1�Ļ��������Ǵ����
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                } else {
                    //do nothing
                }
            } else {
                //monthNow>monthBirth
                age--;
            }
        } else {
            //monthNow<monthBirth
            //donothing
        }

        return age;
    }
    
    /**
     * ���ݵ�ǰʱ���ȡ��ǰ�·�
     * @return
     */
    public static int getDateMonth() {
    	Date date = DateUtil.getDate();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
    	return c.get(Calendar.MONTH) + 1;
    }
}
