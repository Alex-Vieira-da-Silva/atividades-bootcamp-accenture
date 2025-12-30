package Collections;

import java.util.*;

public class ConversorEstruturas {

    private final Scanner scanner = new Scanner(System.in);

    public void executar() {

        List<Map<String, Object>> campos = new ArrayList<>();

        System.out.println("Digite o caractere separador (ex.: ; | :):");
        String separador = scanner.nextLine();

        while (true) {
            System.out.println("Digite no formato CAMPO" + separador + "VALOR" + separador + "TIPO");
            System.out.println("Ou pressione ENTER para finalizar:");
            String entrada = scanner.nextLine();

            if (entrada.isBlank()) break;

            String[] partes = entrada.split(separador);

            if (partes.length < 3) {
                System.out.println("Entrada inválida. Tente novamente.");
                continue;
            }

            String campo = partes[0].trim();
            String valor = partes[1].trim();
            String tipo = partes[2].trim().toLowerCase();

            Object valorConvertido = converterValor(valor, tipo);

            if (valorConvertido == null) {
                System.out.println("Tipo inválido ou valor incompatível.");
                continue;
            }

            Map<String, Object> registro = new LinkedHashMap<>();
            registro.put("campo", campo);
            registro.put("valor", valorConvertido);
            registro.put("tipo", tipo);

            campos.add(registro);
        }

        System.out.println("\n===== JSON =====");
        System.out.println(gerarJSON(campos));

        System.out.println("\n===== XML =====");
        System.out.println(gerarXML(campos));

        System.out.println("\n===== YAML =====");
        System.out.println(gerarYAML(campos));
    }

    private Object converterValor(String valor, String tipo) {
        try {
            switch (tipo) {
                case "texto":
                    return valor;

                case "datas":
                case "data":
                case "data e hora":
                    return valor;

                case "números inteiros":
                case "inteiro":
                    return Integer.parseInt(valor);

                case "números com pontos flutuantes":
                case "decimal":
                case "float":
                case "double":
                    return Double.parseDouble(valor);

                case "boleanos":
                case "booleano":
                    return Boolean.parseBoolean(valor);

                case "array":
                    return Arrays.asList(valor.split(","));

                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    private String gerarJSON(List<Map<String, Object>> campos) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (int i = 0; i < campos.size(); i++) {
            Map<String, Object> c = campos.get(i);
            sb.append("  \"").append(c.get("campo")).append("\": ");

            Object valor = c.get("valor");

            if (valor instanceof String) {
                sb.append("\"").append(valor).append("\"");
            } else if (valor instanceof List) {
                sb.append(valor.toString());
            } else {
                sb.append(valor);
            }

            if (i < campos.size() - 1) sb.append(",");
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

    private String gerarXML(List<Map<String, Object>> campos) {
        StringBuilder sb = new StringBuilder();
        sb.append("<dados>\n");

        for (Map<String, Object> c : campos) {
            sb.append("  <").append(c.get("campo")).append(">");

            Object valor = c.get("valor");

            if (valor instanceof List) {
                sb.append("\n");
                for (Object item : (List<?>) valor) {
                    sb.append("    <item>").append(item).append("</item>\n");
                }
                sb.append("  </").append(c.get("campo")).append(">\n");
            } else {
                sb.append(valor).append("</").append(c.get("campo")).append(">\n");
            }
        }

        sb.append("</dados>");
        return sb.toString();
    }

    private String gerarYAML(List<Map<String, Object>> campos) {
        StringBuilder sb = new StringBuilder();

        for (Map<String, Object> c : campos) {
            sb.append(c.get("campo")).append(": ");

            Object valor = c.get("valor");

            if (valor instanceof List) {
                sb.append("\n");
                for (Object item : (List<?>) valor) {
                    sb.append("  - ").append(item).append("\n");
                }
            } else {
                sb.append(valor).append("\n");
            }
        }

        return sb.toString();
    }
}
