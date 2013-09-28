package com.thenewmotion.time.extension

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
import java.util.Locale
import org.joda.time._, format._

class RichDateTimeFormatter(val self: DateTimeFormatter) extends AnyVal {
  def chronology: Chronology = self.getChronology
  def locale: Locale = self.getLocale
  def parser: DateTimeParser = self.getParser
  def pivotYear: Int = self.getPivotYear.intValue
  def printer: DateTimePrinter = self.getPrinter
  def zone: DateTimeZone = self.getZone
  def parseOption(text: String): Option[DateTime] = try {
      Some(self.parseDateTime(text))
    } catch {
      case _ : UnsupportedOperationException => None
      case _ : IllegalArgumentException => None
    }
}
