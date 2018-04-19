var ocupacionPostal = new CanvasJS.Chart('ocupacionPostal', {
  exportEnabled: false ,
  animationEnabled: true,
  title: {
    text: 'Ocupación del negocio según su procedencia',
    fontFamily: 'Catamaran',
  },
  legend: {
    cursor: 'pointer',
    itemclick: 'explodePie',
  },
  data: [
    {
      type: 'pie',
      showInLegend: true,
      toolTipContent: '{name}: <strong>{y}%</strong>',
      indexLabel: '{name} - {y}%',
      dataPoints: [
        ${dataOcupacionCodigoPostal}
      ],
    }],
});
ocupacionPostal.render();