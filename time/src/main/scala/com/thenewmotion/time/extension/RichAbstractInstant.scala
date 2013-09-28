package com.thenewmotion.time.extension

/**
 * Copyright 2009 Jorge Ortiz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 *
 **/
import java.util.Date
import org.joda.time._, base.AbstractInstant

class RichAbstractInstant(val self: AbstractInstant) extends AnyVal {
  def date: Date = self.toDate
  def dateTime: DateTime = self.toDateTime
  def dateTime(chronology: Chronology): DateTime = self.toDateTime(chronology)
  def dateTime(zone: DateTimeZone): DateTime = self.toDateTime(zone)
  def dateTimeISO: DateTime = self.toDateTimeISO
  def instant: Instant = self.toInstant
  def mutableDateTime: MutableDateTime = self.toMutableDateTime
  def mutableDateTime(chronology: Chronology): MutableDateTime = self.toMutableDateTime(chronology)
  def mutableDateTime(zone: DateTimeZone): MutableDateTime = self.toMutableDateTime(zone)
  def mutableDateTimeISO: MutableDateTime = self.toMutableDateTimeISO
}
