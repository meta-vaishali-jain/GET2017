import { InMemoryDbService } from 'angular-in-memory-web-api';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const products= [
        { id: 11, name: 'Panda Bags' ,price: 100,img_url : './app/Component/products/assets/panda-bags.jpg'},
        { id: 12, name: 'Cute Panda', price: 250,img_url : './app/Component/products/assets/panda.jpg' },
        { id: 13, name: 'Panda Mug', price: 1000,img_url : './app/Component/products/assets/pandaMug.jpg' },
        { id: 14, name: 'Panda Pencil Box', price: 200,img_url : './app/Component/products/assets/PandaPencilBox.jpg' },
        { id: 15, name: 'Panda Phone Cover', price: 3000,img_url : './app/Component/products/assets/pandaPhoneCover.jpg' },
        { id: 16, name: 'Panda Slippers' , price: 400,img_url : './app/Component/products/assets/pandaSlippers.jpg'},
        { id: 17, name: 'Panda Tiffin' , price: 4000,img_url : './app/Component/products/assets/pandatiffin.jpg'},
        { id: 18, name: 'Panda T-shirt', price: 500,img_url : './app/Component/products/assets/pandat-shirt.jpg' },
        { id: 19, name: 'Panda Watch' , price: 200,img_url : './app/Component/products/assets/PandaWatch.jpg'},
        { id: 20, name: 'Small Pandas', price: 1000,img_url : './app/Component/products/assets/pandatoys.jpg' }
    ];
    return {products};
  }
}