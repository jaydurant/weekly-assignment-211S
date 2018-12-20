package week12;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

import java.io.*;

public class HomeworkM11PartTwo {

    public static void main(String[] args) {
        List<Product> productList = createList();
        Supplier<Stream<Product>> streamSupplier = () -> productList.stream();

        System.out.print("hello");
        int numberOfProducts = productList.size();
        System.out.println("Number of products \t\t\t\t\t73425: " + numberOfProducts);
        
        // QUESTION 1: How many total chemicals appear across all products?
        // Example: Product1 contains Chemical1, Chemical2 and Product2 contains Chemical2 and Chemical3 count would be 4 total chemicals
        int numberChemicalsInAllProducts = streamSupplier.get().mapToInt(Product::getNumberOfChemicals).sum();
        System.out.println("Number of chemicals in all products \t\t\t81791: " + numberChemicalsInAllProducts);
        
        // QUESTION 2: How many different companies are in the dataset?
        int numberCompanies = 0;
        numberCompanies = (int)streamSupplier.get().map(product -> product.getCompany()).distinct().count();
        System.out.println("Number of companies \t\t\t\t\t549: " + numberCompanies);
        
        //QUESTION 3: How many products have 4 or more chemicals?
        long numberProductsFourOrMore = streamSupplier.get().filter(product -> product.getNumberOfChemicals() >= 4).count();
        System.out.println("Number of products with 4 or more chemicals \t\t193 :" + numberProductsFourOrMore);
        
        //  QUESTION 4: Create a Map with key = company name and value = list of products for that company.
        // Hint: use Collectors.groupingBy!
        Map<String, List<Product>> companyProductMap = productList.stream().collect(Collectors.groupingBy(Product::getCompany));
        
        // checks that the map is correct; consider adding additional checks!
        System.out.println("Number of companies (keys) \t\t\t\t549: " + companyProductMap.size());
        System.out.println("Number of products for Aloette Cosmetics Inc. \t\t77: " + (companyProductMap.get("Aloette Cosmetics Inc.")).size());
        System.out.println("Number of products for Yves Rocher Inc. \t\t416: " + (companyProductMap.get("Yves Rocher Inc.")).size());
        System.out.println("Number of products for label.m USA INC \t\t\t4: " + (companyProductMap.get("label.m USA INC")).size());
                
        
       // Use this map for the next questions. 
       // This is a map with key = chemical name and value = list of products that contain that chemical.
       // This code creates a map with all chemicals and empty lists.
       Map<String, List<Product>> chemicalProductMap = new HashMap<String, List<Product>>();
       productList.stream().forEach(
               product -> {  product.getChemicals().stream().forEach(
                       chemicalName -> chemicalProductMap.putIfAbsent(chemicalName, new ArrayList<Product>()));
                          }      
               );


    }


    private static List<Product> createList() {
        String line = "";
        String fileName = "ChemicalData.csv";
        List<Product> list = new ArrayList<Product>();

        try (Scanner fileScan = new Scanner(
                new FileReader(new File(fileName)))) {
            line = fileScan.nextLine(); // column headers
            
            while(fileScan.hasNext() ) {
                line = fileScan.nextLine();
                Scanner lineScan = new Scanner(line);
                lineScan.useDelimiter(",");

                String name = lineScan.next();
                String colorScentFlavor = lineScan.next();
                String company  = lineScan.next();
                String brand = lineScan.next();
                String categoryString = lineScan.next();
                String chemicalName = lineScan.next();

                Category category = null;
                Category[] categories = Category.values();
                for(Category categoryOption : categories) {
                    if(categoryString.equalsIgnoreCase(categoryOption.getDescription())) {
                        category = categoryOption;
                    }
                }
               
                Product product = new Product(name, company, brand, colorScentFlavor, category);

                int indexOf = list.indexOf(product);
                if(indexOf<0) {
                    product.addChemical(chemicalName);
                    list.add(product);
                } else {
                    Product existingProduct = list.get(indexOf);
                    existingProduct.addChemical(chemicalName);
                }
            }
        } catch (IOException ex){
            System.out.println(line);

            ex.printStackTrace();
        }
        return list;
    }

}

