package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

/**
 * Enum representing the status of a task or activity.
 * <p>
 * The possible statuses are: pending, scheduled, canceled, completed, and postponed.
 */
public enum Status implements Serializable {
    pending,    // Task or activity is pending
    scheduled,  // Task or activity is scheduled
    canceled,   // Task or activity is canceled
    completed,  // Task or activity is completed
    postponed   // Task or activity is postponed
}
