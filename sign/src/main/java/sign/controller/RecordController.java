package sign.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@RequestMapping(value="/findAllRecord.do")
	@ResponseBody
	public Map<String, Object> findRecordByPageAndSize(Integer page,Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		Subject subject = SecurityUtils.getSubject();
		int uid = (int) subject.getPrincipal();
		List<Record> list = null;
		try {
			list = recordService.findRecordByPageAndSize(page, limit, uid);
			map.put("code", 0);
			map.put("data", list);
			return map;
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			return map;
		}
	}
	
	
	@RequestMapping(value="/addUdate.do")
	@ResponseBody
	public Map<String, Object> addUdate() {
		Map<String, Object> map = new HashMap<String, Object>();
		Subject subject = SecurityUtils.getSubject();
		int uid = (int) subject.getPrincipal();
		
		try {
			recordService.addUdate(uid);
			map.put("code", 0);
			return map;
		} catch (Exception e) {
			
			map.put("msg", e.getMessage());
			return map;
		}
	}
	
	
	
	
}

