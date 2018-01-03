package string.easy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 Input: "PPALLP"
 Output: True
 Input: "PPALLL"
 Output: False
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        return !s.matches(".*L.*L.*L.*|.*A.*A.*");
    }
}
