package com.jcg.jpa;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.persistence.EntityManager;

public class BarChart extends ApplicationFrame {

    public BarChart( String applicationTitle , String chartTitle , EntityManager entityManager) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Name",
                "Duration",
                createDataset(entityManager),
                PlotOrientation.HORIZONTAL,
                false, false, true);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 800 , 600 ) );
        setContentPane( chartPanel );
    }

    private CategoryDataset createDataset(EntityManager entityManager ) {

        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );

        RepositoryMovies repo= new RepositoryMovies();
        for(int i=300; i<330; i++){
            Movies g1=repo.findById(entityManager, i);
            dataset.addValue((double)(g1.getDuration()), g1.getName(),g1.getName());
        }
        return dataset;
    }
}