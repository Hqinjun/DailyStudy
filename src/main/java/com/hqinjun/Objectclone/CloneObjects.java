package com.hqinjun.Objectclone;

import com.hqinjun.Objectclone.DTO.Outputdata;

import java.util.ArrayList;
import java.util.List;

public class CloneObjects {

    private static int num = 600000;

    public static void main(String[] args) throws CloneNotSupportedException {
        List<Outputdata> dataList =  new ArrayList<>();
        long lStart = System.currentTimeMillis();
        for(int i = 0 ; i<num; i++){
            Outputdata outputData  = new Outputdata();
            outputData.setCin("1"+i);
            outputData.setColumnName("1"+2*i);
            outputData.setKey("1key"+i);
            outputData.setTeamKey("1team"+i);
            outputData.setValue("3Value"+2+i);
            dataList.add(outputData);
        }
        long lUseTime = System.currentTimeMillis() - lStart;
        System.out.println(lUseTime);
        dataList.clear();

        Outputdata outputData  = new Outputdata();
        long Start = System.currentTimeMillis();
        for(int i = 0 ; i<num; i++){
            Outputdata outputDataclone  = outputData.clone();
            outputDataclone.setCin("1"+i);
            outputDataclone.setColumnName("1"+2*i);
            outputDataclone.setKey("1key"+i);
            outputDataclone.setTeamKey("1team"+i);
            outputDataclone.setValue("3Value"+2+i);
            dataList.add(outputDataclone);
        }
        long endTime = System.currentTimeMillis() - Start;
        System.out.println(endTime);

    }
}
