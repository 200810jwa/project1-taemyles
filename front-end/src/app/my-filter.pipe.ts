import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'myFilter',
  pure: false
})
export class MyFilterPipe implements PipeTransform {
  transform(value: any, args?: any): any {
    if (!args) {
      return value;
    }
    return value.filter((val) => {
      let rVal = (val.status.name.toLocaleLowerCase().includes(args));
      return rVal;
    })
  }
}