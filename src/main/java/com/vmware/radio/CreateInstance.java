package com.vmware.radio;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceRequest;
import com.aliyuncs.ecs.model.v20140526.CreateInstanceResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.rmi.ServerException;

/**
 * Created by baominw on 6/16/16.
 */
public class CreateInstance {
    public static void main(String[] args) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "accesskey", "securitykey");
        IAcsClient client = new DefaultAcsClient(profile);

        CreateInstanceRequest createInstanceRequest = new CreateInstanceRequest();
        createInstanceRequest.setRegionId("cn-hangzhou");
        createInstanceRequest.setImageId("ubuntu1404_64_40G_aliaegis_20160222.vhd");
        createInstanceRequest.setInstanceType("ecs.n1.small");
        createInstanceRequest.setSecurityGroupId("sg-23jzh8f9y");
        createInstanceRequest.setInstanceName("instance1");
        createInstanceRequest.setInternetChargeType("PayByTraffic");
        createInstanceRequest.setInternetMaxBandwidthIn(1);
        createInstanceRequest.setInternetMaxBandwidthOut(1);
        createInstanceRequest.setIoOptimized("optimized");
        createInstanceRequest.setSystemDiskCategory("cloud_efficiency");
        createInstanceRequest.setPassword("Hello001");

        try {
            CreateInstanceResponse createInstanceResponse
                    = client.getAcsResponse(createInstanceRequest);
            System.out.print(createInstanceResponse.getInstanceId());
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
