package com.carolinarollergirls.scoreboard;
/**
 * Copyright (C) 2008-2012 Mr Temper <MrTemper@CarolinaRollergirls.com>
 *
 * This file is part of the Carolina Rollergirls (CRG) ScoreBoard.
 * The CRG ScoreBoard is licensed under either the GNU General Public
 * License version 3 (or later), or the Apache License 2.0, at your option.
 * See the file COPYING for details.
 */

import java.util.*;

import com.carolinarollergirls.scoreboard.event.*;
import com.carolinarollergirls.scoreboard.xml.*;

public interface ScoreBoard extends ScoreBoardEventProvider
{
  /**
   * Id of Team who called Timeout.
   *
   * The Id is as returned from Team.getId().  For Offical Timeouts, this returns an empty string.
   */
  public String getTimeoutOwner();

  /**
   * If in a Period.
   *
   * This returns true if any Period has started,
   * until the Period is over.  A Period is considered
   * "started" once the first Jam starts.  A Period has
   * not "ended" until its time has expired and the
   * Jam clock has stopped.
   * Note that the Period may end and then re-start
   * (the same Period) if Overtime is started.
   */
  public boolean isInPeriod();

  /**
   * If this bout is in Overtime.
   */
  public boolean isInOvertime();

// FIXME - clock and team getters should either return null or throw exception instead of creating new clock/team...
  public List<Clock> getClocks();
  public Clock getClock(String id);

  public List<Team> getTeams();
  public Team getTeam(String id);

  public List<Policy> getPolicies();
  public Policy getPolicy(String id);

  public XmlScoreBoard getXmlScoreBoard();

  public static final String EVENT_IN_PERIOD = "InPeriod";
  public static final String EVENT_IN_OVERTIME = "InOvertime";
  public static final String EVENT_ADD_POLICY = "AddPolicy";
  public static final String EVENT_REMOVE_POLICY = "RemovePolicy";
  public static final String EVENT_TIMEOUT_OWNER = "TimeoutOwner";
  public static final String EVENT_ADD_CLOCK = "AddClock";
  public static final String EVENT_ADD_TEAM = "AddTeam";
}
