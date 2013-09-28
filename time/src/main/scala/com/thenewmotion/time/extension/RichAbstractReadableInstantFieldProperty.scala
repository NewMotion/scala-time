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
import org.joda.time._, field.AbstractReadableInstantFieldProperty

class RichAbstractReadableInstantFieldProperty(val self: AbstractReadableInstantFieldProperty) extends AnyVal {
  def shortText: String = self.getAsShortText
  def asShortText: String = self.getAsShortText
  def shortText(locale: Locale): String = self.getAsShortText(locale)
  def asShortText(locale: Locale): String = self.getAsShortText(locale)
  def asString: String = self.getAsString
  def text: String = self.getAsText
  def asText: String = self.getAsText
  def text(locale: Locale): String = self.getAsText(locale)
  def asText(locale: Locale): String = self.getAsText(locale)
  def durationField: DurationField = self.getDurationField
  def field: DateTimeField = self.getField
  def fieldType: DateTimeFieldType = self.getFieldType
  def leapAmount: Int = self.getLeapAmount
  def leapDurationField: DurationField = self.getLeapDurationField
  def maximumValue: Int = self.getMaximumValue
  def maxValue: Int = self.getMaximumValue
  def maximumValueOverall: Int = self.getMaximumValueOverall
  def maxValueOverall: Int = self.getMaximumValueOverall
  def minimumValue: Int = self.getMinimumValue
  def minValue: Int = self.getMinimumValue
  def minimumValueOverall: Int = self.getMinimumValueOverall
  def minValueOverall: Int = self.getMinimumValueOverall
  def name: String = self.getName
  def rangeDurationField: DurationField = self.getRangeDurationField

  def interval: Interval = self.toInterval
}
