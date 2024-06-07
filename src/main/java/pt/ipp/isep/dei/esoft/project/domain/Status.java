package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;

public enum Status implements Serializable {
    pending,
    scheduled,
    canceled,
    completed,
    postponed;
}
