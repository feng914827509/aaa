package sign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sign.dao.RecordDao;
import sign.entity.Record;
import sign.service.RecordService;

/** ......................我佛慈悲......................
 *                       _oo0oo_
 *                      o8888888o
 *                      88" . "88
 *                      (| -_- |)
 *                      0\  =  /0
 *                    ___/`---'\___
 *                  .' \\|     |// '.
 *                 / \\|||  :  |||// \
 *                / _||||| -卍- |||||- \
 *               |   | \\\  -  /// |   |
 *               | \_|  ''\---/''  |_/ |
 *               \  .-\__  '-'  ___/-. /
 *             ___'. .'  /--.--\  `. .'___
 *          ."" '<  `.___\_<|>_/___.' >' "".
 *         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *         \  \ `_.   \_ __\ /__ _/   .-` /  /
 *     =====`-.____`.___ \_____/___.-`___.-'=====
 *                       `=---='
 *                       
 *..................佛祖开光 ,永无BUG...................
 * 
 */
@Service
public class RecordServiceImpl implements RecordService{
	@Autowired
	private RecordDao recordDao;
	
	
	@Override
	public void addUdate(int id) {
		
		
	}

	@Override
	public List<Record> findRecordByPageAndSize(Integer page, Integer size,Integer uid) {
		int cpage = (page - 1) * size;
		List<Record> list = null;
		try {
			list = recordDao.findRecordByPageAndSize(cpage, size,uid);
		} catch (Exception e) {
			throw e;
		}
		return list;
	}
	
	
}

