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

class RichDateMidnight(val self: DateMidnight) extends AnyVal {
  def -(duration: Long): DateMidnight = self.minus(duration)
  def -(duration: ReadableDuration): DateMidnight = self.minus(duration)
  def -(period: ReadablePeriod): DateMidnight = self.minus(period)
  def -(builder: DurationBuilder): DateMidnight = self.minus(builder.underlying)
  def +(duration: Long): DateMidnight = self.plus(duration)
  def +(duration: ReadableDuration): DateMidnight = self.plus(duration)
  def +(period: ReadablePeriod): DateMidnight = self.plus(period)
  def +(builder: DurationBuilder): DateMidnight = self.plus(builder.underlying)
}
