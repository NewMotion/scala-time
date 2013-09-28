package com.thenewmotion.time.extension

/**
 * Copyright 2009 Jorge Ortiz
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

class RichLocalDate(val self: LocalDate) extends AnyVal {
  def -(period: ReadablePeriod): LocalDate = self.minus(period)
  def -(builder: DurationBuilder): LocalDate = self.minus(builder.underlying)
  def +(period: ReadablePeriod): LocalDate = self.plus(period)
  def +(builder: DurationBuilder): LocalDate = self.plus(builder.underlying)

  def day: LocalDate.Property = self.dayOfMonth
  def week: LocalDate.Property = self.weekOfWeekyear
  def month: LocalDate.Property = self.monthOfYear
  def year: LocalDate.Property = self.year
  def century: LocalDate.Property = self.centuryOfEra
  def era: LocalDate.Property = self.era

  def withDay(day: Int) = self.withDayOfMonth(day)
  def withWeek(week: Int) = self.withWeekOfWeekyear(week)
  def withMonth(month: Int) = self.withMonthOfYear(month)
  def withYear(year: Int) = self.withYear(year)
  def withCentury(century: Int) = self.withCenturyOfEra(century)
  def withEra(era: Int) = self.withEra(era)
  
  def interval = self.toInterval
}
