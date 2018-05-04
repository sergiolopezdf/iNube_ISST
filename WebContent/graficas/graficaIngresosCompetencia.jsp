var ingresosCompetencia = new CanvasJS.Chart('ingresosCompetencia', {
  animationEnabled: true,
  title: {
    text: 'Ingresos con respecto a la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: 'Ingresos (euros)',
    titleFontColor: 'black',
    lineColor: 'black',
    labelFontColor: 'black',
    tickColor: 'black',
  },
  toolTip: {
    shared: true,
  },
  legend: {
    cursor: 'pointer',
    itemclick: toggleDataSeries,
  },
  data: [
    {
      type: 'column',
      name: 'Comparativa con el resto de restaurantes de la zona',
      legendText: 'Ingresos medios de la competencia',
      showInLegend: true,
      dataPoints: [
        
        ${dataIngresosCompetencia}
        
      ],
    }],
});
ingresosCompetencia.render();

function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === 'undefined' || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ingresosCompetencia.render();
}