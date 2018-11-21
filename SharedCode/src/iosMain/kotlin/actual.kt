package org.kotlin.mpp.mobile

import kotlinx.cinterop.*
import platform.Foundation.*

actual fun httpGet(url:String):String{
  val urlWithString = NSURL.URLWithString(url)
  if (urlWithString != null) {
    val requestWithURL = NSMutableURLRequest.requestWithURL(urlWithString)
    val response: CPointer<ObjCObjectVar<NSURLResponse?>>? = null
    val error : CPointer<ObjCObjectVar<NSError?>>? = null
    val nsData = NSURLConnection.sendSynchronousRequest(requestWithURL, response, error)?.copy() as NSData
      println("nsData: $nsData, lenght: ${nsData.length}, desc: ${nsData.description}")
      println("response: $response")
      val string = NSString.stringWithCString(nsData.bytes() as CPointer<ByteVar>, encoding=NSUTF8StringEncoding)
      if (string != null) {
        return string
      }

  }

  return ""
}



//https://stackoverflow.com/a/24505884