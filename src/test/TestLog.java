import com.dongying.dao.RecordEntityMapper;
import com.dongying.entity.RecordEntity;
import com.dongying.util.ExeclUtil;
import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestLog {
    Logger logger= Logger.getLogger(TestLog.class);
//    @Test
//    public void log4jTest(){
//        logger.error("输出asf输出asdfa输出bbbbasdfadfasdfasfassssssQWEQW ");
//
//    }
    @Autowired
    RecordEntityMapper recordEntityMapper;

    @Test
    public void excel() throws ParseException {
        String filePath = "D:\\record.xls";
        //解析excel，
        List<RecordEntity> list = ExeclUtil.importExcel(filePath,0,1,RecordEntity.class);

//        for(int i=0;i<list.size();i++){
//            Date date= new Date(String.valueOf(list.get(i).getDate()));
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String strDate=sdf.format(date);
//            Date newDate=sdf.parse(strDate);
//            System.out.println(newDate);
//            list.get(i).setDate(date);
//            if(i==0){
//
//             list.get(i).setId(2);
//            }
//            list.get(i).setId(3);
//            System.out.println(list.get(i));
//            recordEntityMapper.insertSelective(list.get(i));
//        }
        RecordEntity recordEntity=new RecordEntity();
        recordEntity.setName("est");
        recordEntity.setSecurity(1);
        recordEntity.setId(5);
        Date date= new Date(String.valueOf("Tue Apr 28 14:00:00 CST 2020"));
        recordEntity.setDate(date);
        System.out.println(recordEntity);
          recordEntityMapper.insertSelective(recordEntity);


    }

}
