/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.business.edge;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import olcm.data.edge.Edges;
import olcm.data.edge.Repo_edge;

/**
 *
 * @author Admin
 */
@Stateless
public class Bean_edge {

    @Inject
    Repo_edge repo_edge;

    public Boolean save(Edge object) {
        Edges edges = new Edges();
        try {
            Converter_edge.ViewToDataModelConverter(edges, object);
            repo_edge.create(edges);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean update(Edge object) {
        Edges edges = new Edges();
        try {
            Converter_edge.ViewToDataModelConverter(edges, object);
            repo_edge.update(edges);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Edge object) {
        Edges edges = new Edges();
        try {
            Converter_edge.ViewToDataModelConverter(edges, object);
            repo_edge.delete(edges);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Edge> getAll() {
        List<Edge> allEdge = new ArrayList();
        List<Edges> allEdges = repo_edge.readAll();
        for (int i = 0; i < allEdges.size(); i++) {
            Edge edge = new Edge();
            Converter_edge.dataToViewModelConverter(allEdges.get(i), edge);
            allEdge.add(edge);
        }
        return allEdge;
    }

    public List<Edge> allEdgesByClassType(long id) throws ParseException {
        List<Edge> allEdge = new ArrayList();
        List<Edges> allEdges = repo_edge.allEdgesByClassType(id);
        for (int i = 0; i < allEdges.size(); i++) {
            Edge edge = new Edge();
            Converter_edge.dataToViewModelConverter(allEdges.get(i), edge);
            allEdge.add(edge);
        }
        return allEdge;
    }

    public Edge getById(Object id) {
        Edge edge = new Edge();
        Edges edges = new Edges();
        edges = repo_edge.read(id);
        Converter_edge.dataToViewModelConverter(edges, edge);
        return edge;
    }
}
