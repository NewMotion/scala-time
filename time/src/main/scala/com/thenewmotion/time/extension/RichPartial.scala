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

class RichPartial(val self: Partial) extends AnyVal {
  def formatter = self.getFormatter
  
  def -(period: ReadablePeriod): Partial = self.minus(period)
  def -(builder: DurationBuilder): Partial = self.minus(builder.underlying)
  def +(period: ReadablePeriod): Partial = self.plus(period)
  def +(builder: DurationBuilder): Partial = self.plus(builder.underlying)
}
