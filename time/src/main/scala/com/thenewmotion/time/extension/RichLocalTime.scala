package com.thenewmotion.time.extension

/**
 * Copyright 2009 Barry Kaplan
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
import com.thenewmotion.time.factory.DurationBuilder

class RichLocalTime(val self: LocalTime) extends AnyVal {
  def -(period: ReadablePeriod): LocalTime = self.minus(period)
  def -(builder: DurationBuilder): LocalTime = self.minus(builder.underlying)
  def +(period: ReadablePeriod): LocalTime = self.plus(period)
  def +(builder: DurationBuilder): LocalTime = self.plus(builder.underlying)

  def second: LocalTime.Property = self.secondOfMinute
  def minute: LocalTime.Property = self.minuteOfHour
  def hour: LocalTime.Property = self.hourOfDay

  def withSecond(second: Int) = self.withSecondOfMinute(second)
  def withMinute(minute: Int) = self.withMinuteOfHour(minute)
  def withHour(hour: Int) = self.withHourOfDay(hour)
}
