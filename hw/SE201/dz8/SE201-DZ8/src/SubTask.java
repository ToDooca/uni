/***********************************************************************
 * Module:  SubTask.java
 * Author:  Dusan
 * Purpose: Defines the Class SubTask
 ***********************************************************************/

import java.util.*;

/** @pdOid 540cbf67-f787-4116-aa95-a523645c2b7c */
public class SubTask extends TaskBuilder {
   /** @pdRoleInfo migr=no name=Task assc=association2 mult=1..1 type=Composition */
   public Task task;

}