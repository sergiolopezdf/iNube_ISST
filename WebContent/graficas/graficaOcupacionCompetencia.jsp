var ocupacionCompetencia = new CanvasJS.Chart('ocupacionCompetencia', {
  animationEnabled: true,
  title: {
    text: 'Ocupaci�n con respecto a la competencia',
    fontFamily: 'Catamaran',
  },
  axisY: {
    title: 'Ocupaci�n (n�mero de transacciones)',
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
      name: 'N� medio de personas en los restaurantes de la zona',
      legendText: 'N� medio de personas',
      showInLegend: true,
      dataPoints: [
        ${dataOcupacionCompetencia}
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