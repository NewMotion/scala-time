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
import java.util.Locale
import org.joda.time.LocalTime

class RichLocalTimeProperty(val self: LocalTime.Property) extends AnyVal {
  def localTime: LocalTime = self.getLocalTime
  def roundFloor: LocalTime = self.roundFloorCopy
  def roundCeiling: LocalTime = self.roundCeilingCopy
  def roundDown: LocalTime = self.roundFloorCopy
  def roundUp: LocalTime = self.roundCeilingCopy
  def round: LocalTime = self.roundHalfEvenCopy

  def apply(value: Int): LocalTime = self.setCopy(value)
  def apply(text: String): LocalTime = self.setCopy(text)
  def apply(text: String, locale: Locale): LocalTime = self.setCopy(text, locale)
}
