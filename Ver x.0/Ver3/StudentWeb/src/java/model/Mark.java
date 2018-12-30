/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Mark{
    private int semesterID;
    private String studentID, subjectID, subjectName, numberOfTinChi, diemCC, diemKT, diemBT, diemTH, diemThi, diemTK, diemChu;

    public Mark() {
    }

    public Mark(int semesterID, String studentID, String subjectID, String subjectName, String numberOfTinChi, String diemCC, String diemKT, String diemBT, String diemTH, String diemThi, String diemTK, String diemChu) {
        this.semesterID = semesterID;
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.numberOfTinChi = numberOfTinChi;
        this.diemCC = diemCC;
        this.diemKT = diemKT;
        this.diemBT = diemBT;
        this.diemTH = diemTH;
        this.diemThi = diemThi;
        this.diemTK = diemTK;
        this.diemChu = diemChu;
    }

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getNumberOfTinChi() {
        return numberOfTinChi;
    }

    public void setNumberOfTinChi(String numberOfTinChi) {
        this.numberOfTinChi = numberOfTinChi;
    }

    public String getDiemCC() {
        return diemCC;
    }

    public void setDiemCC(String diemCC) {
        this.diemCC = diemCC;
    }

    public String getDiemKT() {
        return diemKT;
    }

    public void setDiemKT(String diemKT) {
        this.diemKT = diemKT;
    }

    public String getDiemBT() {
        return diemBT;
    }

    public void setDiemBT(String diemBT) {
        this.diemBT = diemBT;
    }

    public String getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(String diemTH) {
        this.diemTH = diemTH;
    }

    public String getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(String diemThi) {
        this.diemThi = diemThi;
    }

    public String getDiemTK() {
        return diemTK;
    }

    public void setDiemTK(String diemTK) {
        this.diemTK = diemTK;
    }

    public String getDiemChu() {
        return diemChu;
    }

    public void setDiemChu(String diemChu) {
        this.diemChu = diemChu;
    }
    
}
