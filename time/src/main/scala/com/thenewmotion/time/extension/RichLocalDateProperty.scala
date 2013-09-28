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
import org.joda.time.LocalDate

class RichLocalDateProperty(val self: LocalDate.Property) extends AnyVal {
  def localDate: LocalDate = self.getLocalDate
  def roundFloor: LocalDate = self.roundFloorCopy
  def roundCeiling: LocalDate = self.roundCeilingCopy
  def roundDown: LocalDate = self.roundFloorCopy
  def roundUp: LocalDate = self.roundCeilingCopy
  def round: LocalDate = self.roundHalfEvenCopy

  def apply(value: Int): LocalDate = self.setCopy(value)
  def apply(text: String): LocalDate = self.setCopy(text)
  def apply(text: String, locale: Locale): LocalDate = self.setCopy(text, locale)
}
