var vm1 = new Vue({
	el: '#app',
  data: {
    firstNum: 5,
    secondNum: 11
	},
  methods: {
  	show: function() {
    	var firstAsDigit = Number(this.firstNum);
      var secondAsDigit = Number(this.secondNum);
    	alert(firstAsDigit + secondAsDigit);
    }
  }
});
