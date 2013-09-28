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
import com.thenewmotion.time.factory.DurationBuilder

class RichLocalDateTime(val self: LocalDateTime) extends AnyVal {
  def -(duration: ReadableDuration): LocalDateTime = self.minus(duration)
  def -(period: ReadablePeriod): LocalDateTime = self.minus(period)
  def -(builder: DurationBuilder): LocalDateTime = self.minus(builder.underlying)
  def +(duration: ReadableDuration): LocalDateTime = self.plus(duration)
  def +(period: ReadablePeriod): LocalDateTime = self.plus(period)
  def +(builder: DurationBuilder): LocalDateTime = self.plus(builder.underlying)

  def second: LocalDateTime.Property = self.secondOfMinute
  def minute: LocalDateTime.Property = self.minuteOfHour
  def hour: LocalDateTime.Property = self.hourOfDay
  def day: LocalDateTime.Property = self.dayOfMonth
  def week: LocalDateTime.Property = self.weekOfWeekyear
  def month: LocalDateTime.Property = self.monthOfYear
  def year: LocalDateTime.Property = self.year
  def century: LocalDateTime.Property = self.centuryOfEra
  def era: LocalDateTime.Property = self.era

  def withSecond(second: Int) = self.withSecondOfMinute(second)
  def withMinute(minute: Int) = self.withMinuteOfHour(minute)
  def withHour(hour: Int) = self.withHourOfDay(hour)
  def withDay(day: Int) = self.withDayOfMonth(day)
  def withWeek(week: Int) = self.withWeekOfWeekyear(week)
  def withMonth(month: Int) = self.withMonthOfYear(month)
  def withYear(year: Int) = self.withYear(year)
  def withCentury(century: Int) = self.withCenturyOfEra(century)
  def withEra(era: Int) = self.withEra(era)
}
