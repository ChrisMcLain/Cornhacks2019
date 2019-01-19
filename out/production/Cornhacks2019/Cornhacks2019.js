if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Cornhacks2019'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Cornhacks2019'.");
}
var Cornhacks2019 = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var throwCCE = Kotlin.throwCCE;
  var Unit = Kotlin.kotlin.Unit;
  function main$lambda(it) {
    window.alert('test');
    return Unit;
  }
  function main(args) {
    var tmp$;
    var message = 'Hello JavaScript!';
    println(message);
    var testField = Kotlin.isType(tmp$ = document.getElementById('test'), HTMLInputElement) ? tmp$ : throwCCE();
    testField.value = 'this works woo';
    testField.addEventListener('click', main$lambda);
    Cookies.set('test', '123');
    window.alert(Cookies.get('test'));
  }
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('Cornhacks2019', _);
  return _;
}(typeof Cornhacks2019 === 'undefined' ? {} : Cornhacks2019, kotlin);
