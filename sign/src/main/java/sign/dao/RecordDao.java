package sign.dao;

import java.util.List;

import sign.entity.Record;

public interface RecordDao {
	/**
	 * 上下班打卡
	 */
    public void addUdate(String no);
    
    public List<Record> findRecordByPageAndSize(int cpage, int size,int uid);

}