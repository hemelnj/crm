/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

/**
 *
 * @author Admin
 */
public class EdgePostingTemplate {

    private Long id;

    private Long classType;

    private Long status;

    private Long actionEvent;

    private Long endStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassType() {
        return classType;
    }

    public void setClassType(Long classType) {
        this.classType = classType;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(Long actionEvent) {
        this.actionEvent = actionEvent;
    }

    public Long getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(Long endStatus) {
        this.endStatus = endStatus;
    }

}
