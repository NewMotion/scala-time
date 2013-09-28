package com.thenewmotion.time.implicits

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

import scala.language.implicitConversions

import java.sql.Timestamp

import org.joda.time._
import format.DateTimeFormatter
import field.AbstractReadableInstantFieldProperty
import base.{BaseSingleFieldPeriod, AbstractDateTime, AbstractInstant, AbstractPartial}

import com.thenewmotion.time.extension._
import com.thenewmotion.time.factory.DurationBuilder

object All extends All
trait All extends Implicits

@deprecated("use com.thenewmotion.time.implicits.All", "3.0")
object Implicits extends Implicits

object BuilderImplicits extends BuilderImplicits
object IntImplicits extends IntImplicits
object JodaImplicits extends JodaImplicits

trait Implicits
  extends BuilderImplicits
  with IntImplicits
  with JodaImplicits
  with TupleImplicits
  with XmlImplicits
  with JavaImplicits
  with OrderingImplicits

trait BuilderImplicits {
  implicit def forcePeriod(builder: DurationBuilder): Period = builder.underlying
  implicit def forceDuration(builder: DurationBuilder): Duration = builder.underlying.toStandardDuration
}

trait IntImplicits {
  implicit def richInt(n: Int): RichInt = new RichInt(n)
  implicit def richLong(n: Long): RichLong = new RichLong(n)
}

trait JavaImplicits {
  implicit def richTimestamp(self: Timestamp): RichTimestamp = new RichTimestamp(self)
}

trait JodaImplicits {
  implicit def richAbstractDateTime(dt: AbstractDateTime): RichAbstractDateTime = new RichAbstractDateTime(dt)
  implicit def richAbstractInstant(in: AbstractInstant): RichAbstractInstant = new RichAbstractInstant(in)
  implicit def richAbstractPartial(pt: AbstractPartial): RichAbstractPartial = new RichAbstractPartial(pt)
  implicit def richAbstractReadableInstantFieldProperty(pty: AbstractReadableInstantFieldProperty): RichAbstractReadableInstantFieldProperty = new RichAbstractReadableInstantFieldProperty(pty)
  implicit def richChronology(ch: Chronology): RichChronology = new RichChronology(ch)
  implicit def richDateMidnight(dm: DateMidnight): RichDateMidnight = new RichDateMidnight(dm)
  implicit def richDateTime(dt: DateTime): RichDateTime = new RichDateTime(dt)
  implicit def richDateTimeFormatter(fmt: DateTimeFormatter): RichDateTimeFormatter = new RichDateTimeFormatter(fmt)
  implicit def richDateTimeProperty(pty: DateTime.Property): RichDateTimeProperty = new RichDateTimeProperty(pty)
  implicit def richDateTimeZone(zone: DateTimeZone): RichDateTimeZone = new RichDateTimeZone(zone)
  implicit def richDuration(dur: Duration): RichDuration = new RichDuration(dur)
  implicit def richInstant(in: Instant): RichInstant = new RichInstant(in)
  implicit def richLocalDate(ld: LocalDate): RichLocalDate = new RichLocalDate(ld)
  implicit def richLocalDateProperty(pty: LocalDate.Property): RichLocalDateProperty = new RichLocalDateProperty(pty)
  implicit def richLocalDateTime(dt: LocalDateTime): RichLocalDateTime = new RichLocalDateTime(dt)
  implicit def richLocalDateTimeProperty(pty: LocalDateTime.Property): RichLocalDateTimeProperty = new RichLocalDateTimeProperty(pty)
  implicit def richLocalTime(lt: LocalTime): RichLocalTime = new RichLocalTime(lt)
  implicit def richLocalTimeProperty(pty: LocalTime.Property): RichLocalTimeProperty = new RichLocalTimeProperty(pty)
  implicit def richPartial(pt: Partial): RichPartial = new RichPartial(pt)
  implicit def richPartialProperty(pty: Partial.Property): RichPartialProperty = new RichPartialProperty(pty)
  implicit def richPeriod(per: Period): RichPeriod = new RichPeriod(per)
  implicit def richReadableDateTime(dt: ReadableDateTime): RichReadableDateTime = new RichReadableDateTime(dt)
  implicit def richReadableDuration(dur: ReadableDuration): RichReadableDuration = new RichReadableDuration(dur)
  implicit def richReadableInstant(in: ReadableInstant): RichReadableInstant = new RichReadableInstant(in)
  implicit def richReadableInterval(in: ReadableInterval): RichReadableInterval = new RichReadableInterval(in)
  implicit def richReadablePartial(rp: ReadablePartial): RichReadablePartial = new RichReadablePartial(rp)
  implicit def richReadablePeriod(per: ReadablePeriod): RichReadablePeriod = new RichReadablePeriod(per)
}

trait OrderingImplicits extends LowPriorityOrderingImplicits {
  implicit val DateTimeOrdering = ReadableInstantOrdering[DateTime]
  implicit val DateMidnightOrdering = ReadableInstantOrdering[DateMidnight]
  implicit val LocalDateOrdering = ReadablePartialOrdering[LocalDate]
  implicit val LocalTimeOrdering = ReadablePartialOrdering[LocalTime]
  implicit val LocalDateTimeOrdering = ReadablePartialOrdering[LocalDateTime]
  implicit val DurationOrdering = ReadableDurationOrdering[Duration]
}

trait LowPriorityOrderingImplicits {
  implicit def ReadableInstantOrdering[A <: ReadableInstant] = order[A, ReadableInstant]
  implicit def ReadablePartialOrdering[A <: ReadablePartial] = order[A, ReadablePartial]
  implicit def BaseSingleFieldPeriodOrdering[A <: BaseSingleFieldPeriod] = order[A, BaseSingleFieldPeriod]
  implicit def ReadableDurationOrdering[A <: ReadableDuration] = order[A, ReadableDuration]
  private def order[A, B <: Comparable[B]](implicit ev: A <:< B): Ordering[A] = Ordering.by[A, B](ev)
}

trait XmlImplicits {
  import javax.xml.datatype.{XMLGregorianCalendar, DatatypeFactory}

  lazy val datatypeFactory = DatatypeFactory.newInstance

  implicit def dateTime2XmlGregCalendar(dt: DateTime) = datatypeFactory.newXMLGregorianCalendar(dt.toGregorianCalendar)

  implicit def xmlGregCalendar2DateTime(calendar: XMLGregorianCalendar) = new DateTime(calendar.toGregorianCalendar.getTimeInMillis)
}

trait TupleImplicits {
  type Year = Int
  type Month = Int
  type Day = Int
  type Hour = Int
  type Minute = Int
  type Second = Int
  type Millis = Int

  implicit def tuple2Time(t: (Year, Month, Day)): DateTime = {
    val (year, month, day) = t
    new DateTime(year, month, day, 0, 0, 0, 0)
  }

  implicit def tuple2Time(t: (Year, Month, Day, Hour)): DateTime = {
    val (year, month, day, hour) = t
    new DateTime(year, month, day, hour, 0, 0, 0)
  }

  implicit def tuple2Time(t: (Year, Month, Day, Hour, Minute)): DateTime = {
    val (year, month, day, hour, minute) = t
    new DateTime(year, month, day, hour, minute, 0, 0)
  }

  implicit def tuple2Time(t: (Year, Month, Day, Hour, Minute, Second)): DateTime = {
    val (year, month, day, hour, minute, second) = t
    new DateTime(year, month, day, hour, minute, second, 0)
  }

  implicit def tuple2Time(t: (Year, Month, Day, Hour, Minute, Second, Millis)): DateTime = {
    val (year, month, day, hour, minute, second, millis) = t
    new DateTime(year, month, day, hour, minute, second, millis)
  }
}
