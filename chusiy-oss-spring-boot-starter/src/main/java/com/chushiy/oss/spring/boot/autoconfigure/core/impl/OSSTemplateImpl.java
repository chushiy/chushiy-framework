package com.chushiy.oss.spring.boot.autoconfigure.core.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;
import com.chushiy.oss.spring.boot.autoconfigure.core.OSSTemplate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/29 下午 8:50
 * @Description OSS操作模版实现 参考 https://docs.aws.amazon.com/AmazonS3/latest/API/API_CreateBucket.html
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.oss.spring.boot.autoconfigure.core.impl
 * @ClassName OSSTemplateImpl.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public class OSSTemplateImpl implements OSSTemplate {

    private final AmazonS3 amazonS3;

    @SneakyThrows
    @Override
    public void createBucket(String bucketName) {
        if (!amazonS3.doesBucketExistV2(bucketName)) {
            amazonS3.createBucket((bucketName));
        }
    }

    @Override
    @SneakyThrows
    public List<Bucket> getAllBuckets() {
        return amazonS3.listBuckets();
    }

    @SneakyThrows
    @Override
    public void removeBucket(String bucketName) {
        amazonS3.deleteBucket(bucketName);
    }

    @SneakyThrows
    @Override
    public void putObject(String bucketName, String objectName, InputStream stream, String contextType) {
        this.putObject(bucketName, objectName, stream, stream.available(), contextType);
    }

    @SneakyThrows
    @Override
    public void putObject(String bucketName, String objectName, InputStream stream) {
        this.putObject(bucketName, objectName, stream, stream.available(), "application/octet-stream");
    }

    @SneakyThrows
    @Override
    public S3Object getObject(String bucketName, String objectName) {
        return amazonS3.getObject(bucketName, objectName);
    }

    @SneakyThrows
    @Override
    public String getObjectURL(String bucketName, String objectName, Integer expires) {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, expires);
        URL url = amazonS3.generatePresignedUrl(bucketName, objectName, calendar.getTime());
        return url.toString();
    }

    @SneakyThrows
    @Override
    public void removeObject(String bucketName, String objectName) {
        amazonS3.deleteObject(bucketName, objectName);
    }

    @SneakyThrows
    @Override
    public List<S3ObjectSummary> getAllObjectsByPrefix(String bucketName, String prefix, boolean recursive) {
        ObjectListing objectListing = amazonS3.listObjects(bucketName, prefix);
        return objectListing.getObjectSummaries();
    }

    @SneakyThrows
    private PutObjectResult putObject(String bucketName, String objectName, InputStream stream, long size, String contextType) {
        byte[] bytes = IOUtils.toByteArray(stream);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(size);
        objectMetadata.setContentType(contextType);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        // 上传
        return amazonS3.putObject(bucketName, objectName, byteArrayInputStream, objectMetadata);
    }
}
