package com.thenewmotion.time

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

object StaticDuration extends StaticDuration {
  def apply(dur: Long) = new Duration(dur)
  def empty            = Duration.ZERO
  def ∅                = empty
}

trait StaticDuration {
  def standardDays(days: Long) = Duration.standardDays(days)
  def standardHours(hours: Long) = Duration.standardHours(hours)
  def standardMinutes(minutes: Long) = Duration.standardMinutes(minutes)
  def standardSeconds(seconds: Long) = Duration.standardSeconds(seconds)
}
