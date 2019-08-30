import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'differ'
})
export class DifferPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    var result:string="";
    var a=value.value;
       var i=value.length;
    if(args[1].length==0){
      result="This field is required";
    }
    else{
      if(args[1].length!=10){
      result="Account number must be 10 digits.!"
       }

    else{
   if(a==args[0])
    result="From and To account numbers must not be same.!";
  
  }
}
    return result;
  }

}
