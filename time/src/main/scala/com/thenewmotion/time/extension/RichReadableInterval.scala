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
import scala.annotation.tailrec

class RichReadableInterval(val self: ReadableInterval) extends AnyVal {
  def chronology: Chronology = self.getChronology
  def end: DateTime = self.getEnd
  def start: DateTime = self.getStart

  def duration: Duration = self.toDuration
  def millis: Long = self.toDuration.getMillis
  // TODO: Should > and > be added as aliases for isAfter and isBefore?
  //   could be convenient, or just confusing because this isn't Ordered.

  def days: List[DateTime] = {
    val from = start
    val to = end
    @tailrec
    def recur(acc: List[DateTime], curr: DateTime, target: DateTime): List[DateTime] = {
      if(curr.toDateMidnight == target.toDateMidnight) acc
      else recur(curr :: acc, curr plusDays 1, target)
    }
    recur(Nil, from, to)
  }
}
