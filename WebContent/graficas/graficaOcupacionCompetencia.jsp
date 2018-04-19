var ocupacionCompetencia = new CanvasJS.Chart('ocupacionCompetencia', {
  animationEnabled: true,
  title: {
    text: 'Ocupación con respecto a la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: 'Ocupación %',
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
        ${dataOcupacionCompetencia}
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
ocupacionCompetencia.render();

function toggleDataSeries(e) {
  if (typeof(e.dataSeries.visible) === 'undefined' || e.dataSeries.visible) {
    e.dataSeries.visible = false;
  }
  else {
    e.dataSeries.visible = true;
  }
  ocupacionCompetencia.render();
}