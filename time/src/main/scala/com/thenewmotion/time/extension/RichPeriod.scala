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
import org.joda.time._

class RichPeriod(val self: Period) extends AnyVal {
  def days: Int = self.getDays
  def hours: Int = self.getHours
  def millis: Int = self.getMillis
  def minutes: Int = self.getMinutes
  def months: Int = self.getMonths
  def seconds: Int = self.getSeconds
  def weeks: Int = self.getWeeks
  def years: Int = self.getYears
  def -(period: ReadablePeriod): Period = self.minus(period)
  def +(period: ReadablePeriod): Period = self.plus(period)
  def ago: DateTime = DateTime.now.minus(self)
  def later: DateTime = DateTime.now.plus(self)
  def from(dt: DateTime): DateTime = dt.plus(self)
  def before(dt: DateTime): DateTime = dt.minus(self)
  
  def standardDuration: Duration = self.toStandardDuration
}
