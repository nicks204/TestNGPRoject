package Maven.Maven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AwsJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AWSCredentials credentials = new BasicAWSCredentials(
				  "AKIA2JZIYU53U4X5ZGY3", 
				  "Sy87JCLpV/MSzeAvz67OlgvKUTZyKB6IxsJidGnK"
				);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_2)
				  .build();
		
		//======== Create S3 Bucket =================
		
		String bucketName = "n210bucket";

		if(s3client.doesBucketExist(bucketName)) {
		   
		    return;
		}

		s3client.createBucket(bucketName);
		
		s3client.putObject(
				  "n210bucket", 
				  "myimage", 
				  new File("C:\\Users\\TiaaUser\\OneDrive\\Desktop\\Docker\\Git Commands.txt")
				);
		
		
		

		//======== List S3 Bucket =================
		
		List<Bucket> buckets = s3client.listBuckets();
		for(Bucket bucket : buckets) {
		    System.out.println(bucket.getName());
		}
		
		
		//======== Put Objects into S3 Bucket =================
		
		s3client.putObject(
				  "nikunjpublic", 
				  "myimage", 
				  new File("C:\\Users\\TiaaUser\\OneDrive\\Desktop\\Docker\\Git Commands.txt")
				);
		
		
		//======== List Objects into S3 Bucket =================
		
	
		ObjectListing objectListing = s3client.listObjects(bucketName);
		for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
		    System.out.println(os.getKey());
		}
		
		
		//======== Delete S3 Bucket =================
		
		
		S3Object s3object = s3client.getObject(bucketName, "picture/pic.png");
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		

		try {
			FileUtils.copyInputStreamToFile(inputStream, new File("/Users/user/Desktop/hello.txt"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
		    s3client.deleteBucket("n205bucket");
		} catch (AmazonServiceException e) {
		    System.err.println("error");
		    return;
		}
		
		
	}
	 
	

}
