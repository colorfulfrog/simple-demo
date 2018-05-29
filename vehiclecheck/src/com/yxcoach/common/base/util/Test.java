package com.yxcoach.common.base.util;

public class Test {
	public static void main(String[] args) {
		String resdata="<response><status>1</status><info>ok</info><infocode>10000</infocode><locations>112.889921875,28.210227593316;112.889921875,28.210227593316</locations></response>";
		int start=resdata.indexOf("<locations>");
		int end=resdata.indexOf("</locations>");
		String gpsdata=resdata.substring(start+11, end);
		System.err.println(gpsdata);
	}
}
