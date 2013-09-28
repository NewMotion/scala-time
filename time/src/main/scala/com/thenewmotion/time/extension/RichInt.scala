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
package com.thenewmotion.time.extension

import org.joda.time.Period
import com.thenewmotion.time.factory.DurationBuilder

class RichInt(val self: Int) extends AnyVal {
  // These units of time can build durations or periods.
  // At most we lose a leap second. (Unless someone adopts
  // leap minutes).
  def millis  = DurationBuilder(Period.millis(self))
  def seconds = DurationBuilder(Period.seconds(self))
  def minutes = DurationBuilder(Period.minutes(self))
  def hours   = DurationBuilder(Period.hours(self))

  // These units of time can only be periods. At this
  // point if we made durations automatically we'd start
  // getting into trouble with daylight savings time,
  // monthly differences, leap years, etc.
  def days   = Period.days(self)
  def weeks  = Period.weeks(self)
  def months = Period.months(self)
  def years  = Period.years(self)

  // See above.
  def milli  = DurationBuilder(Period.millis(self))
  def second = DurationBuilder(Period.seconds(self))
  def minute = DurationBuilder(Period.minutes(self))
  def hour   = DurationBuilder(Period.hours(self))

  // See above.
  def day   = Period.days(self)
  def week  = Period.weeks(self)
  def month = Period.months(self)
  def year  = Period.years(self)
}
