/**
 * Copyright 2009 Jorge Ortiz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 **/
package com.thenewmotion.time.factory

import java.util.Locale
import org.joda.time.format.{DateTimeFormat => fmt, DateTimeFormatter}

object StaticDateTimeFormat {
  def forPattern(pattern: String): DateTimeFormatter = fmt.forPattern(pattern)
  def forStyle(style: String): DateTimeFormatter = fmt.forStyle(style)
  def fullDate(): DateTimeFormatter = fmt.fullDate()
  def fullDateTime(): DateTimeFormatter = fmt.fullDateTime()
  def fullTime(): DateTimeFormatter = fmt.fullTime()
  def longDate(): DateTimeFormatter = fmt.longDate()
  def longDateTime(): DateTimeFormatter = fmt.longDateTime()
  def longTime(): DateTimeFormatter = fmt.longTime()
  def mediumDate(): DateTimeFormatter = fmt.mediumDate()
  def mediumDateTime(): DateTimeFormatter = fmt.mediumDateTime()
  def mediumTime(): DateTimeFormatter = fmt.mediumTime()
  def patternForStyle(style: String, locale: Locale): String = fmt.patternForStyle(style, locale)
  def shortDate(): DateTimeFormatter = fmt.shortDate()
  def shortDateTime(): DateTimeFormatter = fmt.shortDateTime()
  def shortTime(): DateTimeFormatter = fmt.shortTime()
}
