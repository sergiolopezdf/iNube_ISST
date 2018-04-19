var ingresosCompetencia = new CanvasJS.Chart('ingresosCompetencia', {
  animationEnabled: true,
  title: {
    text: 'Ingresos con respecto a la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: 'Ingresos €',
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
      name: 'Tu Restaurante',
      legendText: 'Tu Restaurante',
      showInLegend: true,
      dataPoints: [
        
        ${dataIngresosCompetencia}
        
      ],
    },
    {
      type: 'column',
      name: 'Compentencia',
      legendText: 'Competencia',
      showInLegend: true,
      dataPoints: [
       
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