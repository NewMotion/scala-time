package com.thenewmotion.time.factory

import org.joda.time.format.{ISODateTimeFormat => fmt}

object StaticISODateTimeFormat {
  /** @see [[org.joda.time.format.ISODateTimeFormat#date()]]*/
  def date                            = fmt.date
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#time()]]*/
  def time                            = fmt.time
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#timeNoMillis()]]*/
  def timeNoMillis                    = fmt.timeNoMillis
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#tTime()]]*/
  def tTime                           = fmt.tTime
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#tTimeNoMillis()]]*/
  def tTimeNoMillis                   = fmt.tTimeNoMillis
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#dateTime()]]*/
  def dateTime                        = fmt.dateTime
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#dateTimeNoMillis()]]*/
  def dateTimeNoMillis                = fmt.dateTimeNoMillis
  

  /** @see [[org.joda.time.format.ISODateTimeFormat#ordinalDate()]]*/
  def ordinalDate                     = fmt.ordinalDate
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#ordinalDateTime()]]*/
  def ordinalDateTime                 = fmt.ordinalDateTime
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#ordinalDateTimeNoMillis()]]*/
  def ordinalDateTimeNoMillis         = fmt.ordinalDateTimeNoMillis
  

  /** @see [[org.joda.time.format.ISODateTimeFormat#weekDate()]]*/
  def weekDate                        = fmt.weekDate
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#weekDateTime()]]*/
  def weekDateTime                    = fmt.weekDateTime
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#weekDateTimeNoMillis()]]*/
  def weekDateTimeNoMillis            = fmt.weekDateTimeNoMillis
  

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicDate()]]*/
  def basicDate                       = fmt.basicDate
  
  /** @see [[org.joda.time.format.ISODateTimeFormat#basicTime()]]*/
  def basicTime                       = fmt.basicTime

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicTimeNoMillis()]]*/
  def basicTimeNoMillis               = fmt.basicTimeNoMillis

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicTTime()]]*/
  def basicTTime                      = fmt.basicTTime

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicTTimeNoMillis()]]*/
  def basicTTimeNoMillis              = fmt.basicTTimeNoMillis

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicDateTime()]]*/
  def basicDateTime                   = fmt.basicDateTime

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicDateTimeNoMillis()]]*/
  def basicDateTimeNoMillis           = fmt.basicDateTimeNoMillis

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicOrdinalDate()]]*/
  def basicOrdinalDate                = fmt.basicOrdinalDate

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicOrdinalDateTime()]]*/
  def basicOrdinalDateTime            = fmt.basicOrdinalDateTime

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicOrdinalDateTimeNoMillis()]]*/
  def basicOrdinalDateTimeNoMillis    = fmt.basicOrdinalDateTimeNoMillis

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicWeekDate()]]*/
  def basicWeekDate                   = fmt.basicWeekDate

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicWeekDateTime()]]*/
  def basicWeekDateTime               = fmt.basicWeekDateTime

  /** @see [[org.joda.time.format.ISODateTimeFormat#basicWeekDateTimeNoMillis()]]*/
  def basicWeekDateTimeNoMillis       = fmt.basicWeekDateTimeNoMillis


  /** @see [[org.joda.time.format.ISODateTimeFormat#year()]]*/
  def year                            = fmt.year

  /** @see [[org.joda.time.format.ISODateTimeFormat#yearMonth()]]*/
  def yearMonth                       = fmt.yearMonth

  /** @see [[org.joda.time.format.ISODateTimeFormat#yearMonthDay()]]*/
  def yearMonthDay                    = fmt.yearMonthDay


  /** @see [[org.joda.time.format.ISODateTimeFormat#weekyear()]]*/
  def weekyear                        = fmt.weekyear

  /** @see [[org.joda.time.format.ISODateTimeFormat#weekyearWeek()()]]*/
  def weekyearWeek                    = fmt.weekyearWeek

  /** @see [[org.joda.time.format.ISODateTimeFormat#weekyearWeekDay()()]]*/
  def weekyearWeekDay                 = fmt.weekyearWeekDay


  /** @see [[org.joda.time.format.ISODateTimeFormat#hour()]]*/
  def hour                            = fmt.hour

  /** @see [[org.joda.time.format.ISODateTimeFormat#hourMinute()]]*/
  def hourMinute                      = fmt.hourMinute

  /** @see [[org.joda.time.format.ISODateTimeFormat#hourMinuteSecond()]]*/
  def hourMinuteSecond                = fmt.hourMinuteSecond

  /** @see [[org.joda.time.format.ISODateTimeFormat#hourMinuteSecondMillis()]]*/
  def hourMinuteSecondMillis          = fmt.hourMinuteSecondMillis

  /** @see [[org.joda.time.format.ISODateTimeFormat#hourMinuteSecondFraction()]]*/
  def hourMinuteSecondFraction        = fmt.hourMinuteSecondFraction


  /** @see [[org.joda.time.format.ISODateTimeFormat#dateHour()]]*/
  def dateHour                        = fmt.dateHour

  /** @see [[org.joda.time.format.ISODateTimeFormat#dateHourMinute()]]*/
  def dateHourMinute                  = fmt.dateHourMinute

  /** @see [[org.joda.time.format.ISODateTimeFormat#dateHourMinuteSecond()]]*/
  def dateHourMinuteSecond            = fmt.dateHourMinuteSecond

  /** @see [[org.joda.time.format.ISODateTimeFormat#dateHourMinuteSecondMillis()]]*/
  def dateHourMinuteSecondMillis      = fmt.dateHourMinuteSecondMillis

  /** @see [[org.joda.time.format.ISODateTimeFormat#dateHourMinuteSecondFraction()]]*/
  def dateHourMinuteSecondFraction    = fmt.dateHourMinuteSecondFraction
}
