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
import java.sql.Timestamp
import org.joda.time._
import com.thenewmotion.time.factory.DurationBuilder

class RichDateTime(val self: DateTime) extends AnyVal {
  def -(duration: Long): DateTime = self.minus(duration)

  def -(duration: ReadableDuration): DateTime = self.minus(duration)

  def -(period: ReadablePeriod): DateTime = self.minus(period)

  def -(builder: DurationBuilder): DateTime = self.minus(builder.underlying)

  def +(duration: Long): DateTime = self.plus(duration)

  def +(duration: ReadableDuration): DateTime = self.plus(duration)

  def +(period: ReadablePeriod): DateTime = self.plus(period)

  def +(builder: DurationBuilder): DateTime = self.plus(builder.underlying)

  def second: DateTime.Property = self.secondOfMinute

  def minute: DateTime.Property = self.minuteOfHour

  def hour: DateTime.Property = self.hourOfDay

  def day: DateTime.Property = self.dayOfMonth

  def week: DateTime.Property = self.weekOfWeekyear

  def month: DateTime.Property = self.monthOfYear

  def year: DateTime.Property = self.year

  def century: DateTime.Property = self.centuryOfEra

  def era: DateTime.Property = self.era

  def withSecond(second: Int) = self.withSecondOfMinute(second)

  def withMinute(minute: Int) = self.withMinuteOfHour(minute)

  def withHour(hour: Int) = self.withHourOfDay(hour)

  def withDay(day: Int) = self.withDayOfMonth(day)

  def withWeek(week: Int) = self.withWeekOfWeekyear(week)

  def withMonth(month: Int) = self.withMonthOfYear(month)

  def withYear(year: Int) = self.withYear(year)

  def withCentury(century: Int) = self.withCenturyOfEra(century)

  def withEra(era: Int) = self.withEra(era)

  def compare(that: RichDateTime) = self.compareTo(that.self)

  def monthInterval: Interval = {
    val start = withDay(1).toDateMidnight
    new Interval(start, start.plusMonths(1))
  }

  def dayInterval: Interval = {
    val start = new DateMidnight(self.getMillis, self.getChronology)
    new Interval(start, start.plusDays(1))
  }

  def toTimestamp: Timestamp = new Timestamp(self.getMillis)
}
