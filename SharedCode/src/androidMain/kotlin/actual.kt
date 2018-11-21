package org.kotlin.mpp.mobile

import java.net.URI

actual fun httpGet(url:String):String{
  return URI(url).toURL().readText()
}